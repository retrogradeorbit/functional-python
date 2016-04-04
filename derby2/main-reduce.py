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
        lambda sim, n: sim.add(
            vehicle.Vehicle().set_pos(
                vec2.zero.random_unit().scale(arena_size)
            ).set_vel(
                vec2.i.rotate(random() * math.pi * 2))),
        range(num_cars),
        derby.Derby())

    step_storage = {}
    print simulation
    for step in range(simulation_steps):
        if step in remember_steps:
            step_storage[step] = simulation

        simulation = simulation.update()

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
        print "sum_vel", step_storage[step].sum_vel(),
        print "sum_pos", step_storage[step].sum_pos()
    print

    print "derby2"
    print "======"
    print derby.Derby().add(vehicle.Vehicle(vec2.zero, vec2.zero))

    print
    print "derby now"
    print "========="
    print simulation



if __name__=="__main__":
    main()
