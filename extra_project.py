import numpy as np
from matplotlib import pyplot as plt
import math

dt = math.pow(10, -3) #step size
t=np.linspace(0, dt, int(math.pow(10, 5))) #vector of t values from 0 to dt  of size 10,000
n = len(t) #n = 10,000
q = np.zeros([n]) # zero array of size 10,000
q[0] = 1 #IVP: q'(0) = 0 for positive charge
u = np.zeros([n]) #zero array of size 10,000
u[0] = 1 #IVP: q(0) = 1 for positive charge
E = 0.52 #Epsilon value
for i in range(0, n-1): #Loops through to get successive Euler approximations
    l = i*dt
    if math.floor(l) % 2 == 0: #even numbered intervals use q+
        u[i+1] = u[i] +  dt*-q[i]/(1+E)
    else: #odd numbered intervals use q-
        u[i+1] = u[i] + dt*-q[i]/(1-E)
    q[i+1] = q[i] + dt*u[i]
#Plots function and titles plot and axes
plt.plot(q,u, 'r')
plt.xlabel('q')
plt.ylabel('dq/dt')
plt.title('Current vs. Charge')
plt.show()