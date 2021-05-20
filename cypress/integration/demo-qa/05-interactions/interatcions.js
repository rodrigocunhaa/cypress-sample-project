/// <reference types="cypress" />

describe("Test Interactions on Demo QA site", () => {

    it("Should be able to do Droppable interactions", () => {

        cy.visit("https://www.demoqa.com/droppable");

        cy.get('#simpleDropContainer > #draggable').drag('#simpleDropContainer > #droppable', 'center');

    });

    it("Should be able to do Droppable interactions --- seleniumeasy site", () => {

        cy.visit("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

        cy.get('#todrag>span:nth-child(2)').drag('#mydropzone', 'center');

    });

});