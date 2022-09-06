CREATE TABLE IF NOT EXISTS "author" (
    "author_id" SERIAL, -- author_id – primary key of the table.
    "author_name" varchar(50) NOT NULL, -- author_name – complete name of the author.
    "author_display_name" varchar(30) NOT NULL, -- author_display_name – the name that will be displayed in the article. This column serves as the code name of the author.
    "author_email" CUSTOM_EMAIL_TYPE, -- author_email – email address of the author.
    "author_account_status" BOOLEAN NOT NULL DEFAULT FALSE, -- author_account_status – account status refers to the login status of the author, 0 is for deactivated, and 1 is for activated.
    "author_profile_URL" VARCHAR NOT NULL, -- author_profile_URL – the profile image of the author.
    "username" varchar(30) NOT NULL, -- username – the desired username of the author.
    "created_at" CUSTOM_INDIA_NOW,
    "updated_at" CUSTOM_INDIA_NOW,
    PRIMARY KEY ("author_id")
);

CREATE TABLE IF NOT EXISTS "subscriber" (
    "subscriber_id" SERIAL, -- subscriber_id – primary key of the table.
    "subscriber_display_name" varchar(30) NOT NULL, -- subscriber_display_name – the code name of the subscriber, they can choose to display their real name or their code name.
    "subscriber_name" varchar(50) NOT NULL, -- subscriber_name – this field will store the real name of the subscriber.
    "subscriber_email" CUSTOM_EMAIL_TYPE, -- subscriber_email – email address of the subscriber, they can receive updates from the site through their email address.
    "subscriber_profile_URL" VARCHAR NOT NULL, -- subscriber_profile_URL – the image profile of the subscriber.
    "username" varchar(30) NOT NULL, -- username – the desired username of the subscriber.
    "account_status" BOOLEAN NOT NULL DEFAULT FALSE, -- account_status – account status refers to the login status of the subscriber, 0 is for deactivated, and 1 is for activated.
    "created_at" CUSTOM_INDIA_NOW, -- date_joined – the registration date of the subscriber.
    "date_approved" CUSTOM_INDIA_NOW, -- date_approved – the account will be reviewed by the administrator and this column refers to the approval date.
    "updated_at" CUSTOM_INDIA_NOW,
    PRIMARY KEY ("subscriber_id")
);

CREATE TABLE IF NOT EXISTS "newscategory" (
    "category_id" SERIAL, -- category_id – primary key of the table.
    "category_name" varchar(30) NOT NULL, -- category_name – name of the category.
    "category_description" varchar(50) NOT NULL, -- category_description – brief description about the category.
    PRIMARY KEY ("category_id")
);



CREATE TABLE IF NOT EXISTS "news" (
    "news_id" SERIAL, -- news_id – this is the primary key of the table.
    "category_id" int NOT NULL, -- category_id – the news will be grouped according to their type and its content; this is the foreign key that links to the tblnewscategory table.
    "date_posted" CUSTOM_INDIA_NOW, -- date_posted – this column refers to the posting date of the news or article.
    "news_title" varchar(100) NOT NULL, -- news_title – the title of the content or news.
    "news_content" text NOT NULL, -- news_content – the body of the news.
    "date_updated" CUSTOM_INDIA_NOW, -- date_updated – this will record the date when the author updates the contents of the news.
    "news_status" BOOLEAN NOT NULL DEFAULT(FALSE), -- news_status – this column has two values 0 and 1, 0 for unpublished, 1 for published.
    "comment_status" BOOLEAN NOT NULL DEFAULT(FALSE), -- comment_status – the author can set the news if it can accept comment or not.
    "author_id" int NOT NULL, -- author_id – this column represents the author of the article. This is a foreign key that links to the tblauthor.
    PRIMARY KEY ("news_id"),
    FOREIGN KEY ("author_id") REFERENCES author("author_id") ON DELETE CASCADE,
    FOREIGN KEY ("category_id") REFERENCES newscategory("category_id") ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS "comment" (
    "comment_id" SERIAL, -- comment_id – primary key of the table.
    "comment_content" varchar(100) NOT NULL, -- comment_content – the comment of the subscriber will be stored in this column.
    "subscriber_id" int NOT NULL, -- subscriber_id – this is a foreign key that links to the tblsubscriber, this column refers to the subscriber who posted a comment into the article.
    "news_id" int NOT NULL, -- news_id – this is a foreign key that links to the tblnews table.
    "comment_date" CUSTOM_INDIA_NOW, -- comment_date – the posting date of the comment.
    "comment_status" BOOLEAN NOT NULL DEFAULT FALSE, -- comment_status – comments will not be automatically posted on the website, it will be reviewed first by the administrator/moderator of the system.
    "user_id" int NOT NULL, -- user_id – the user who approves the comment.
    PRIMARY KEY ("comment_id"),
    FOREIGN KEY("subscriber_id") REFERENCES subscriber("subscriber_id") ON DELETE CASCADE,
    FOREIGN KEY("news_id") REFERENCES news("news_id") ON DELETE CASCADE,
    FOREIGN KEY("user_id") REFERENCES author("author_id") ON DELETE CASCADE
);