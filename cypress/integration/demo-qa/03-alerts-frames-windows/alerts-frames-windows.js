/// <reference types="cypress" />

describe("Test Alerts, Frames and Windows on Demo QA site", () => {

    it("Should be able to interact with alerts 1  - Click Button to see alert", () => {

        cy.visit("https://www.demoqa.com/alerts");

        cy.xpath("//button[@id='alertButton']").click();

        cy.on('window:alert', (text) => {
            expect(text).to.contains('You clicked a button');
        });

    });

    it("Should be able to interact with alerts 2 - Alert appears after 5 seconds", () => {

        cy.visit("https://www.demoqa.com/alerts");

        cy.xpath("//button[@id='timerAlertButton']").click();

        cy.wait(5000);

        cy.on('window:alert', (text) => {
            expect(text).to.contains('This alert appeared after 5 seconds');
        });

    });

    it("Should be able to interact with alerts 3 - Select Cancel on confirm box", () => {

        cy.visit("https://www.demoqa.com/alerts");

        cy.on("window:confirm", (text) => {
            return false;
        });

        cy.xpath("//button[@id='confirmButton']").click();

        cy.xpath("//span[@id='confirmResult']").should('include.text', 'You selected Cancel');

    });

    it("Should be able to interact with alerts 4 - Select Ok on confirm box", () => {

        cy.visit("https://www.demoqa.com/alerts");

        cy.on("window:confirm", (text) => {
            return true;
        });

        cy.xpath("//button[@id='confirmButton']").click();

        cy.xpath("//span[@id='confirmResult']").should('include.text', 'You selected Ok');

    });

    it("Should be able to interact with alerts 5 - Fill prompt box", () => {

        cy.visit("https://www.demoqa.com/alerts");

        cy.window().then(function (promptelement) {
            cy.stub(promptelement, "prompt").returns("Luiz Inácio Lula da Silva");
        });

        cy.xpath("//button[@id='promtButton']").click();

        cy.xpath("//span[@id='promptResult']").should('include.text', 'You entered Luiz Inácio Lula da Silva');

    });

});

