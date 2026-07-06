import pytest

@pytest.mark.activity
def test_add():
    num1 = 10;
    num2 = 12;

    assert num1 + num2 == 22

@pytest.mark.activity
def test_sub():
    num1 = 10;
    num2 = 5;

    assert num1 - num2 == 5

@pytest.mark.activity
def test_mul():
    num1 = 10;
    num2 = 10;

    assert num1 * num2 == 100

@pytest.mark.activity
def test_div():
    num1 = 10;
    num2 = 5;

    assert num1 / num2 == 2.0