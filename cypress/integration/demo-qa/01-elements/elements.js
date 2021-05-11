/// <reference types="cypress" />

describe("Test Elements on Demo QA site", () => {

    it("Should be able to fill Text Box and submit the form", () => {

        cy.visit("https://www.demoqa.com/text-box");

        cy.xpath("//input[@id='userName']").type("Diamond Farley");

        cy.xpath("//input[@id='userEmail']").type("dfarley@demoqa.com");

        cy.xpath("//textarea[@id='currentAddress']").type("986 Golden Star Ave.Oxford, MS 38655");

        cy.xpath("//textarea[@id='permanentAddress']").type("90 E. St Margarets St.Springfield, PA 19064");

        cy.xpath("//button[@id='submit']").click();

        cy.xpath("//p[@id='name']").should('include.text', 'Diamond Farley');

        cy.xpath("//p[@id='email']").should('include.text', 'dfarley@demoqa.com');

        cy.xpath("//p[@id='currentAddress']").should('include.text', '986 Golden Star Ave.Oxford, MS 38655');

        cy.xpath("//p[@id='permanentAddress']").should('include.text', '90 E. St Margarets St.Springfield, PA 19064');

    });

    it("Should be able to fill Checkbox", () => {

        cy.visit("https://www.demoqa.com/checkbox");

        cy.xpath("//button[contains(@class,'option-expand-all')]").click();

        cy.xpath("//label[@for='tree-node-private']").click();

        cy.xpath("//div[@id='result']").should('include.text', 'private');

    });

    it("Should be able to fill Radio Button", () => {

        cy.visit("https://www.demoqa.com/radio-button");

        cy.xpath("//input[@id='impressiveRadio']").check({force: true});

        cy.xpath("//span[@class='text-success']").should('include.text', 'Impressive');

    });

    it("Should be able to read from Table", () => {

        cy.visit("https://www.demoqa.com/webtables");

        cy.xpath("//input[@id='searchBox']").type("2000");

        cy.xpath("//div[@role='gridcell']").should('include.text', 'Alden');

        cy.xpath("//div[@role='gridcell']").should('include.text', '12000');

        cy.xpath("//div[@role='gridcell']").should('include.text', 'Kierra');

        cy.xpath("//div[@role='gridcell']").should('include.text', '2000');

        cy.xpath("//button[@id='addNewRecordButton']").click();

        cy.xpath("//input[@id='firstName']").type("Diamond");

        cy.xpath("//input[@id='lastName']").type("Farley");

        cy.xpath("//input[@id='userEmail']").type("dfarley@demoqa.com");

        cy.xpath("//input[@id='age']").type("45");

        cy.xpath("//input[@id='salary']").type("2000");

        cy.xpath("//input[@id='department']").type("IT");

        cy.xpath("//button[@id='submit']").click();

        cy.xpath("//div[@role='gridcell']").should('include.text', 'Farley');

        cy.xpath("//input[@id='searchBox']").clear();

        cy.xpath("//input[@id='searchBox']").type("45");

        cy.xpath("//div[@role='gridcell']").should('not.contain.text', 'Kierra');

    });
});