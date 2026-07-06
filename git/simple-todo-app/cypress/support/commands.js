// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })

Cypress.Commands.add('addTodo', (text) => {
  cy.get('[data-cy="todo-input"]').type(text)
  cy.get('[data-cy="add-button"]').click()
})

Cypress.Commands.add('getDataByCy', (locator) =>{
    return cy.get(`[data-cy="${locator}"]`)
})

Cypress.Commands.add('completeTodo', (index) => {
  cy.get('[data-cy="todo-item"]')
    .eq(index)
    .find('[data-cy="todo-checkbox"]')
    .check()
})