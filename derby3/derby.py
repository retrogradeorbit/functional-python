import vec2
import vehicle

def new(vehicles=()):
    return tuple(vehicles)

def add(derby, vehicle):
    return new(derby + (vehicle,))

def remove(derby, vehicle):
    return new(v for v in derby if v != vehicle)

def update(derby):
    return new(vehicle.update(vehicle.wander(v)) for v in derby)

def sum_vel(derby):
    return reduce(lambda x, y: vec2.add(x, y['vel']), derby, vec2.zero)

def sum_pos(derby):
    return reduce(lambda x, y: vec2.add(x, y['pos']), derby, vec2.zero)
