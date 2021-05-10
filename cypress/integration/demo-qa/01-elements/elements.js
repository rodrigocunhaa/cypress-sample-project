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
});