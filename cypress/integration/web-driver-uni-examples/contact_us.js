/// <reference types="cypress" />

describe("Test Contact Us form", () => {

    it("Should be able to submit the form", () => {

        cy.visit("http://www.webdriveruniversity.com/Contact-Us/contactus.html");

        cy.get('[name="first_name"]').type("First");
        cy.get('[name="last_name"]').type("Last");
        cy.get('[name="email"]').type("f@l.com");
        cy.get('textarea.feedback-input').type("comment");

        cy.get('[type="submit"]').click();

        cy.url().should('include', 'contact-form-thank-you.html');
        cy.get('h1').should('have.text', 'Thank You for your Message!');

    });

    it("Should not be able to submit the form as the fields are required - missing comment", () => {

        cy.visit("http://www.webdriveruniversity.com/Contact-Us/contactus.html");

        cy.get('[name="first_name"]').type("First");
        cy.get('[name="last_name"]').type("Last");
        cy.get('[name="email"]').type("f@l.com");

        cy.get('[type="submit"]').click();

        cy.url().should('not.include', 'contact-form-thank-you.html');
        cy.get('body').should('include.text', 'Error: all fields are required');

    });

    it("Should not be able to submit the form as the fields are required - missing email", () => {

        cy.visit("http://www.webdriveruniversity.com/Contact-Us/contactus.html");

        cy.get('[name="first_name"]').type("First");
        cy.get('[name="last_name"]').type("Last");
        cy.get('textarea.feedback-input').type("comment");

        cy.get('[type="submit"]').click();

        cy.url().should('not.include', 'contact-form-thank-you.html');
        cy.get('body').should('include.text', 'Error: all fields are required');
        cy.get('body').should('include.text', 'Error: Invalid email address');

    });

    it("Should not be able to submit the form as the fields are required - missing first name", () => {

        cy.visit("http://www.webdriveruniversity.com/Contact-Us/contactus.html");

        cy.get('[name="last_name"]').type("Last");
        cy.get('[name="email"]').type("f@l.com");
        cy.get('textarea.feedback-input').type("comment");

        cy.get('[type="submit"]').click();

        cy.url().should('not.include', 'contact-form-thank-you.html');
        cy.get('body').should('include.text', 'Error: all fields are required');

    });

    it("Should not be able to submit the form as the fields are required - missing last name", () => {

        cy.visit("http://www.webdriveruniversity.com/Contact-Us/contactus.html");

        cy.get('[name="first_name"]').type("First");
        cy.get('[name="email"]').type("f@l.com");
        cy.get('textarea.feedback-input').type("comment");

        cy.get('[type="submit"]').click();

        cy.url().should('not.include', 'contact-form-thank-you.html');
        cy.get('body').should('include.text', 'Error: all fields are required');

    });

    it("Should not be able to submit the form as the fields are required - missing all fields", () => {

        cy.visit("http://www.webdriveruniversity.com/Contact-Us/contactus.html");

        cy.get('[type="submit"]').click();

        cy.url().should('not.include', 'contact-form-thank-you.html');
        cy.get('body').should('include.text', 'Error: all fields are required');
        cy.get('body').should('include.text', 'Error: Invalid email address');

    });
    
})