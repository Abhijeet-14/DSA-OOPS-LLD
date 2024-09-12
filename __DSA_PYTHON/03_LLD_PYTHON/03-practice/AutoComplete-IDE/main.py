"""
User Input --> Lexical Analyzer --> Context Manager --> Suggestion Engine --> Code Database/Trie
                            |                                   |
                            |---> Scope Resolver & Ranking <--  |
                                                                 |
                            |--> Suggestion Renderer             |

"""
class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end_of_word = True

    def search(self, prefix):
        node = self.root
        for char in prefix:
            if char not in node.children:
                return []
            node = node.children[char]
        return self._autocomplete(node, prefix)

    def _autocomplete(self, node, prefix):
        results = []
        if node.is_end_of_word:
            results.append(prefix)
        
        for char, child_node in node.children.items():
            results.extend(self._autocomplete(child_node, prefix + char))
        
        return results


class AutocompleteEngine:
    def __init__(self):
        self.trie = Trie()
        self.context = ""
        self.suggestions = []

    def load_keywords(self, keywords):
        for word in keywords:
            self.trie.insert(word)

    def handle_input(self, user_input):
        if user_input == " ":
            self.context = ""
            return
        self.context += user_input
        self.suggestions = self.trie.search(self.context)
        self.display_suggestions()

    def display_suggestions(self):
        if self.suggestions:
            print(f"Suggestions for '{self.context}': {', '.join(self.suggestions)}")
        else:
            print(f"No suggestions for '{self.context}'")

    def reset_context(self):
        self.context = ""

# Sample Keywords (In a real scenario, these could be function names, variable names, etc.)
keywords = ["print", "println", "property", "prototype", "process", "program", "progress", "project"]

# Initialize and load keywords into the autocomplete engine
engine = AutocompleteEngine()
engine.load_keywords(keywords)

# Simulate user input
user_inputs = ["p", "r", "o", " ","prog"]

for input_char in user_inputs:
    engine.handle_input(input_char)
