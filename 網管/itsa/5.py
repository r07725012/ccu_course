n = int(raw_input())

while n>0:
    disks = int(raw_input())
    disklist = (raw_input()).split()
    step = 0

    for i in range(0,disks):
        step += int(disklist[i]) * 2**((len(disklist)-i-1))
    print step
    n-=1