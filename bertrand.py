import random
import itertools
import math 

def check_in_circle(x, y):
	circle = (x * x) + (y * y)
	if circle <= 1:
		return True
	else:
		return False 

def generate_random_points():
	points = []
	legal_points = []
	for i in range(0, 1000):
		rand = random.uniform(-1, 1)
		points.append(rand)
	all_x_y = list(itertools.permutations(points, 2))
	size_all_points = len(all_x_y)
	for i in range(0, size_all_points):
		point = all_x_y[i]
		check = check_in_circle(all_x_y[i][0], all_x_y[i][1])
		if(check):
			legal_points.append(point)
	return legal_points

def case_one():
	points = generate_random_points()
	size = len(points)
	lengths = []
	for i in range(0, size):
		x = points[i][0]
		y = points[i][1]
		length = math.sqrt(1-(x*x + y*y))
		length = 2 * length
		lengths.append(length)
	sqrt_three = math.sqrt(3)
	size = len(lengths)
	greater_sqrt_three = []
	for i in range(0, size):
		if lengths[i] > sqrt_three:
			greater_sqrt_three.append(lengths[i])
	size_greater_list = len(greater_sqrt_three)
	probability = size_greater_list / float(size)
	print probability

def case_two():
	r_points = []
	for i in range(0, 1000):
		rand = random.uniform(-1, 1)
		r_points.append(rand)
	size = len(r_points)
	all_r = []
	for i in range(0, size):
		point = r_points[i]
		length = math.sqrt(1 - point * point)
		length = 2 * length
		all_r.append(length)
	sqrt_three = math.sqrt(3)
	greater_sqrt_three = []
	for i in range(0, size):
		if all_r[i] > sqrt_three:
			greater_sqrt_three.append(all_r[i])
	size_greater_list = len(greater_sqrt_three)
	probability = size_greater_list / float(size)
	print probability

def case_three():
	alpha_points = []
	for i in range(0, 1000):
		rand = random.uniform(0, 2 * math.pi)
		alpha_points.append(rand)
	alpha_lengths = []
	size = len(alpha_points)
	sqrt_three = math.sqrt(3)
	for i in range(0, size):
		length = math.sqrt(2 - 2 * math.cos(alpha_points[i]))
		if length > sqrt_three:
			alpha_lengths.append(length)
	size_greater_list = len(alpha_lengths)
	probability = size_greater_list / float(size)
	print probability




case_one()
case_two()
case_three()