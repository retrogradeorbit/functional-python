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

    simulation = derby.Derby()
    for n in range(num_cars):
        start_pos = vec2.zero
        start_pos.random_unit()
        start_pos.scale(arena_size)

        start_vel = vec2.i
        start_vel.rotate(random() * math.pi * 2)

        car = vehicle.Vehicle()
        car.set_pos(start_pos)
        car.set_vel(start_vel)
        simulation.add(car)

    step_storage = {}
    for step in range(simulation_steps):
        if step in remember_steps:
            step_storage[step] = simulation

        simulation.update()

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
    simulation2 = derby.Derby()
    simulation2.add(vehicle.Vehicle(vec2.zero, vec2.zero))
    print simulation2

    print
    print "derby now"
    print "========="
    print simulation



if __name__=="__main__":
    main()
