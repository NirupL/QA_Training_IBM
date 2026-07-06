import pytest


def test_sum(num_list):
    sum = 0
    for i in num_list:
        sum += i
    assert sum == 55

def test_largest(num_list):
    assert max(num_list) == 10