import pytest

@pytest.fixture
def input_value():
    return 40

@pytest.fixture
def num_list():
    return range(11)

@pytest.fixture
def wallet():
    return 0