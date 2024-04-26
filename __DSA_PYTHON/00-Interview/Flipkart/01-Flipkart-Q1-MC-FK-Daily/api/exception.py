import logging

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)


def handle_exception(func, show_exception=False):
    def wrapper(*args, **kwargs):
        try:
            return func(*args, **kwargs)
        except Exception as e:
            logger.exception(e) if show_exception else print(e)
            print()

    return wrapper
