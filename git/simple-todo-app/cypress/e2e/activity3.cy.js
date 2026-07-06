describe('Testing with custom commands', () => {

  beforeEach(() => {
    cy.visit("http://localhost:3000");
  });

  describe('adding tasks', () => {
    it('add todo tasks', () => {
      //add the tasks using the custom commands
      cy.addTodo('Task 1')
      cy.addTodo('Task 2')
      cy.addTodo('Task 3')

      //verify there are three
      cy.getDataByCy('todo-item').should("have.length", 3)
    })
  })

  describe('marking tasks as complete', () => {
    it('should mark two as complete', () =>{
      //add the tasks using the custom commands
      cy.addTodo('Task 1')
      cy.addTodo('Task 2')
      cy.addTodo('Task 3')

      //mark it as complete
      cy.getDataByCy('todo-checkbox').eq(0).check()
      cy.getDataByCy('todo-checkbox').eq(1).check()

      //verify the first two are checked
      cy.getDataByCy('todo-checkbox').eq(0).should('be.checked')
      cy.getDataByCy('todo-checkbox').eq(1).should('be.checked')
      cy.getDataByCy('todo-checkbox').eq(2).should('not.be.checked')
    })
  })

  describe('deleting the tasks', () => {
    it('should mark two as complete', () =>{
      //add the tasks using the custom commands
      cy.addTodo('Task 1')
      cy.addTodo('Task 2')
      cy.addTodo('Task 3')

      //mark it as complete
      cy.getDataByCy('todo-checkbox').eq(0).check()
      cy.getDataByCy('todo-checkbox').eq(1).check()

      //verify the first two are checked
      cy.getDataByCy('todo-checkbox').eq(0).should('be.checked')
      cy.getDataByCy('todo-checkbox').eq(1).should('be.checked')
      cy.getDataByCy('todo-checkbox').eq(2).should('not.be.checked')

      //delete the third one
      cy.getDataByCy('delete-button').eq(2).click()

      //verify it has only two items
      cy.getDataByCy('todo-item').should("have.length", 2)

    })
  })
})