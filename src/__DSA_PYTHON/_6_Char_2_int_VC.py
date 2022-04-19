d = {
    '1': 'Dhoni',
    '2': 'Dravid',
    '3': 'sachin'
}

print('\nDictionary loop over key & values')

for key, value in d.items():
    print(key, value)


# d.items gives array of [.., tuple(key, value), ..]
print(d.items())


print('\nStore to a key')
dict = {}

for i in range(1,6):
    dict[i] = i*i

for k, v in dict.items():
    print(k, v)