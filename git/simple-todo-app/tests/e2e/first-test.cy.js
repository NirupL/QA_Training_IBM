describe("My First Test", () => {
  it("visits the todo app", () => {
    cy.log("Going to the page!");
    cy.visit("http://localhost:3000");
    cy.contains("Todo List");
  });
});
