/// <reference types="cypress" />

describe("Test Contact Us form via Automation Test Store", () => {

    it("Should be able to submit the form", () => {

        cy.visit("https://automationteststore.com/");

        cy.xpath("//a[contains(text(),'Contact Us')]").click();

        cy.xpath("//input[@id='ContactUsFrm_first_name']").type("First");

        cy.xpath("//input[@id='ContactUsFrm_email']").type("email@domain.com");

        cy.xpath("//textarea[@id='ContactUsFrm_enquiry']").type("enquiry");

        cy.xpath("//button[contains(@title, 'Submit')]").click();

    });
});