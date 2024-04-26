from model.user import User


class DB:
    items = {}
    active_items = {}
    users: dict[str, User] = {}
