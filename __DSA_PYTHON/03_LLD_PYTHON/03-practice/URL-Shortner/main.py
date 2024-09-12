"""
  +--------------------+       +-----------------------+       +-----------------------+
  |  User Interface     |       |  URL Shortening       |       |  Redirection Service   |
  | (Form, API Gateway) | ----> |    Service            | ----> | (Handles redirect)     |
  +--------------------+       +-----------------------+       +-----------------------+
                                    |
                                    v
                            +-------------------+
                            |   Database (SQL,  |
                            |   NoSQL, Cache)   |
                            +-------------------+

"""

import string
import random

class URLShortener:
    def __init__(self):
        # In-memory database to store short -> long URL mapping
        self.url_mapping = {}
        # Base URL for all shortened URLs
        self.base_url = "https://short.ly/"
        # Characters for generating the short URL (Base62)
        # Length of the random short URL string
        self.short_url_length = 6

    def generate_short_url(self):
        """Generates a random short URL key."""
        base62_chars = string.ascii_letters + string.digits
        return ''.join(random.choice(base62_chars) for _ in range(self.short_url_length))

    def shorten_url(self, long_url):
        """Shortens a long URL and stores the mapping."""
        short_url_key = self.generate_short_url()
        # Ensure uniqueness of the short URL by checking if it already exists
        while short_url_key in self.url_mapping:
            short_url_key = self.generate_short_url()
        
        # Store the short -> long URL mapping
        self.url_mapping[short_url_key] = long_url
        # Return the full shortened URL
        return self.base_url + short_url_key

    def get_long_url(self, short_url_key):
        """Returns the original long URL corresponding to the short URL key."""
        return self.url_mapping.get(short_url_key, None)

# Simulating the system
if __name__ == "__main__":
    url_shortener = URLShortener()

    # Example long URL
    long_urls = [
        "https://www.example.com/very-long-url",
        "https://abc.com/xyz/123/orp/lmn",
    ]
    
    # Shorten the URL
    short_urls = []
    for long_url in long_urls:
        short_url = url_shortener.shorten_url(long_url)
        short_urls += [short_url]
        print(f"Original URL: {long_url}")
        print(f"Shortened URL: {short_url}")
    
    # Extract short URL key (last part of the shortened URL)
    for short_url in short_urls:
        short_url_key = short_url.split('/')[-1]

        # Retrieve the long URL using the short URL key
        retrieved_url = url_shortener.get_long_url(short_url_key)
        print(f"Retrieved URL from '{short_url}': {retrieved_url}")
