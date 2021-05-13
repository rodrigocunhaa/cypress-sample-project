/// <reference types="cypress" />

describe("Test Widgets on Demo QA site", () => {

    it("Should be able to interact with Accordion Widgets", () => {

        cy.visit("https://demoqa.com/accordian");

        cy.xpath("//div[@id='section1Heading']").should('have.text','What is Lorem Ipsum?').next().should('have.attr', 'class','collapse show');
        cy.xpath("//div[@id='section2Heading']").should('have.text','Where does it come from?').next().should('have.attr', 'class','collapse');
        cy.xpath("//div[@id='section3Heading']").should('have.text','Why do we use it?').next().should('have.attr', 'class','collapse');
        cy.xpath("//div[@id='section1Content']").should('contains.text','Lorem Ipsum is simply dummy text of the printing and typesetting industry.');

        cy.xpath("//div[@id='section2Heading']").should('have.text','Where does it come from?').click();
        cy.xpath("//div[@id='section1Heading']").should('have.text','What is Lorem Ipsum?').next().should('have.attr', 'class','collapse');
        cy.xpath("//div[@id='section2Heading']").should('have.text','Where does it come from?').next().should('have.attr', 'class','collapse show');
        cy.xpath("//div[@id='section3Heading']").should('have.text','Why do we use it?').next().should('have.attr', 'class','collapse');
        cy.xpath("//div[@id='section2Content']").should('contains.text','Contrary to popular belief, Lorem Ipsum is not simply random text.');

        cy.xpath("//div[@id='section3Heading']").should('have.text','Why do we use it?').click();
        cy.xpath("//div[@id='section1Heading']").should('have.text','What is Lorem Ipsum?').next().should('have.attr', 'class','collapse');
        cy.xpath("//div[@id='section2Heading']").should('have.text','Where does it come from?').next().should('have.attr', 'class','collapse');
        cy.xpath("//div[@id='section3Heading']").should('have.text','Why do we use it?').next().should('have.attr', 'class','collapse show');
        cy.xpath("//div[@id='section3Content']").should('contains.text','It is a long established fact that a reader will be distracted by the readable content');

        cy.xpath("//div[@id='section3Heading']").should('have.text','Why do we use it?').click();
        cy.xpath("//div[@id='section1Heading']").should('have.text','What is Lorem Ipsum?').next().should('have.attr', 'class','collapse');
        cy.xpath("//div[@id='section2Heading']").should('have.text','Where does it come from?').next().should('have.attr', 'class','collapse');
        cy.xpath("//div[@id='section3Heading']").should('have.text','Why do we use it?').next().should('have.attr', 'class','collapse');
    });

    it("Should be able to interact with Auto Complete Widgets", () => {

        cy.visit("https://demoqa.com/auto-complete");

        cy.xpath('//*[@id="autoCompleteMultipleContainer"]').type('r')
        cy.xpath("//*[contains(@class,'auto-complete__option')]").contains('Green').click();
        cy.xpath('//*[@id="autoCompleteMultipleContainer"]').type('r')
        cy.xpath("//*[contains(@class,'auto-complete__option')]").contains('Red').click();

        cy.xpath("//*[contains(@class,'auto-complete__multi-value__label')]").contains('Green').should('be.visible');
        cy.xpath("//*[contains(@class,'auto-complete__multi-value__label')]").contains('Red').should('be.visible');

        cy.xpath('//*[@id="autoCompleteSingleContainer"]').type('r')
        cy.xpath("//*[contains(@class,'auto-complete__option')]").contains('Purple').click();

        cy.xpath("//*[contains(@class,'auto-complete__single-value')]").contains('Purple').should('be.visible');

        cy.xpath('//*[@id="autoCompleteSingleContainer"]').type('r')
        cy.xpath("//*[contains(@class,'auto-complete__option')]").contains('Green').click();

        cy.xpath("//*[contains(@class,'auto-complete__single-value')]").contains('Purple').should('not.exist');
        cy.xpath("//*[contains(@class,'auto-complete__single-value')]").contains('Green').should('be.visible');
    });
});