select 
    n.news_title, n.news_content, 
    a.author_name, a.author_email, a."author_profile_URL",
    n.news_status, n.date_posted ,c.comment_content, 
    s.subscriber_name, s.subscriber_email, s."subscriber_profile_URL",
    nc.category_name, nc.category_description
from news as n
    JOIN author as a ON n.author_id = a.author_id
    JOIN "comment" as c ON n.news_id = c.news_id
    JOIN subscriber as s ON s.subscriber_id = c.subscriber_id
    JOIN newscategory as nc ON n.category_id = nc.category_id