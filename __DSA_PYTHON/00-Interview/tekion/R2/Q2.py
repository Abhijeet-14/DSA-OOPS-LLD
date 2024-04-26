"""
Write a code to get the innermost dictionary in this nested dictionary. 
It is guaranteed that only one key will have a dictionary as it’s value. 
Your code should work for other dictionaries as well.
inner_most = {    
    "glossary": {
        "title": "example glossary",
        "GlossDiv": {
            "title": "S",
            "GlossList": {
                "GlossEntry": {
                    "ID": "SGML",
                    "SortAs": "SGML",
                    "GlossTerm": "Standard Generalized Markup Language",
                    "Acronym": "SGML",
                    "Abbrev": "ISO 8879:1986",
                    "GlossDef": {
                        "para": "A meta-markup language, used to create markup languages such as DocBook.",
                        "GlossSeeAlso": ["GML", "XML"]
                    },
                    "GlossSee": "markup"
                }
            }
        }
    }
}

"GlossDef": {
    "para": "A meta-markup language, used to create markup languages such as DocBook.",
    "GlossSeeAlso": ["GML", "XML"]
},
"""


# {} - {}
def get_inner_most_dict(dict1: dict):

    inner_most = dict1  # {}
    for key, value in dict1.items():
        if isinstance(value, dict):
            inner_most = get_inner_most_dict(value)
    return inner_most


inner_most = {
    "glossary": {
        "title": "example glossary",
        "GlossDiv": {
            "title": "S",
            "GlossList": {
                "GlossEntry": {
                    "ID": "SGML",
                    "SortAs": "SGML",
                    "GlossTerm": "Standard Generalized Markup Language",
                    "Acronym": "SGML",
                    "Abbrev": "ISO 8879:1986",
                    "GlossDef": {
                        "para": "A meta-markup language, used to create markup languages such as DocBook.",
                        "GlossSeeAlso": ["GML", "XML"],
                    },
                    "GlossSee": "markup",
                }
            },
        },
    }
}
print(get_inner_most_dict(inner_most))
