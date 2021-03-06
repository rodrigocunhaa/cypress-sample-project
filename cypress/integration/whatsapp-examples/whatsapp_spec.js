// describe('My First Test', () => {
//     it('Does not do much!', () => {
//       expect(true).to.equal(false)
//     })
//   })

describe('My First Test', () => {
    it('Visits the Kitchen Sink', () => {
      cy.visit('http://web.whatsapp.com/');

      cy.get('._1awRl');
    });
  })