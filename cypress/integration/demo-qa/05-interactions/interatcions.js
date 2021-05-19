/// <reference types="cypress" />

describe("Test Interactions on Demo QA site", () => {

    it("Should be able to do Droppable interactions", () => {

        cy.visit("https://www.demoqa.com/droppable");

        cy.get('#simpleDropContainer > #draggable').drag('#simpleDropContainer > #droppable', 'center');

    });

});