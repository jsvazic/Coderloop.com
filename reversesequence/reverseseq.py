import sys

def generate_map(fname):
	map = {}
	for line in open(fname):
		key, value = line.strip().split()
		map[key] = value
	return map
	
def find_first_name(map):
	diff = set(map.keys()) - set(map.values())
	return diff.pop()
		
map = generate_map(sys.argv[1])
name = find_first_name(map)
names = [ ]
while name is not None:
	names.append(name)
	if name in map:	name = map[name]
	else: name = None

names.reverse()
for name in names:
	print name