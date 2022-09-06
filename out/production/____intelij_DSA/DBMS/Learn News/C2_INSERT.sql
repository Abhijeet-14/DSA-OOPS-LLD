-------------------------------------
-- Insert "author"
INSERT INTO 
author (
    "author_name",
    "author_display_name",
    "author_email",
    "author_profile_URL",
    "username"
) 
values(
    'author_name_1', 
    'author_display_name_1', 
    'author@email.com', -- email check
    'author_profile_URL',
    'username'
)

-------------------------------------
-- ALTER COLUMN TYPE to CUSTOM_TYPE
ALTER TABLE public."author"
ALTER COLUMN "author_email" TYPE custom_email_type

-------------------------------------
-- Insert "subscriber"
INSERT INTO 
"subscriber" (
    "subscriber_display_name",
    "subscriber_name",
    "subscriber_email",
    "subscriber_profile_URL",
    "username",
    "date_joined",
    "date_approved",
)
VALUES (
    "subscriber_display_name",
    "subscriber_name",
    "subscriber@email.com",
    "subscriber_profile_URL",
    "username",
    "date_joined",
    "date_approved",
)

-------------------------------------
-- ALTER TABLE
create_at TIMESTAMPTZ DEFAULT Now() SET TIMEZONE='Asia/Kolkata';

-------------------------------------
-- Insert "newscategory"
INSERT INTO 
newscategory (
    "category_name",
    "category_description"
) 
values(
    'category_name_2',
    'category_description_2'
);

-------------------------------------
-- Insert "news"
 INSERT INTO 
news (
    "category_id",
    "news_title",
    "news_content",
    "author_id"
) 
values(
    1,
    'news_title_1',
    'news_content_1',
    2
);

-------------------------------------
-- Insert "comment"
INSERT INTO 
"comment" (
    "comment_content",
    "subscriber_id",
    "news_id",
    "comment_status",
    "user_id"
) 
values(
    'comment_content_1',
    3,
    1,
    true,
    2
    
);