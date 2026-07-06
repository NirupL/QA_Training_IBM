
while True:

    player1 = input("Enter your choice : ")
    player2 = input("Enter your choice : ")

    if player1 == "rock":
        if player2 == "scissors":
            print("player 1 wins")
        elif player2 == "rock":
            print("it is a tie")
        else:
            print("player 2 wins")
    elif player1 == "scissors":
        if player2 == "paper":
            print("player 1 wins")
        elif player2 == "scissors":
            print("it is a tie")
        else:
            print("player 2 wins")
    else:
        if player2 == "rock":
            print("player 1 wins")
        elif player2 == "paper":
            print("it is a tie")
        else:
            print("player 2 wins")


    again = input("Wanna play again (y/n)")
    if again == "y":
        pass
    else:
        raise SystemExit