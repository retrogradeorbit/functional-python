from random import random
import math

import vec2
import vehicle
import derby

def main():
    num_cars = 5
    arena_size = 100
    simulation_steps = 1000
    remember_steps = (0, 499, 999)

    simulation = reduce(
        lambda sim, n: derby.add(
            sim,
            vehicle.set_vel(
                vehicle.set_pos(
                    vehicle.new(),
                    vec2.scale(vec2.random_unit(), arena_size)
                ),
                vec2.rotate(vec2.i, random() * math.pi * 2))),
        range(num_cars),
        derby.new())

    step_storage = {}
    print simulation
    for step in range(simulation_steps):
        if step in remember_steps:
            step_storage[step] = simulation

        simulation = derby.update(simulation)

    print "derby"
    print "====="
    for step in remember_steps:
        print "step:", step
        print step_storage[step]
        print

    print "final state"
    print "==========="
    print simulation
    print

    print "Summage"
    print "======="
    for step in remember_steps:
        print "step:", step,
        print "sum_vel", derby.sum_vel(step_storage[step])
        print "sum_pos", derby.sum_pos(step_storage[step])
    print

    print "derby2"
    print "======"
    print derby.add(
        derby.new(),
        vehicle.new(vec2.zero, vec2.zero)
    )

    print
    print "derby now"
    print "========="
    print simulation



if __name__=="__main__":
    main()
