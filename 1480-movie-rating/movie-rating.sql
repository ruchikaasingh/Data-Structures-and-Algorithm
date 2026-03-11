(select u.name as results from movierating mr
inner join users as u on mr.user_id = u.user_id
group by u.user_id
order by count(mr.movie_id) desc, u.name asc 
limit 1)

union all

(select m.title as results from movierating mr
inner join movies as m on mr.movie_id = m.movie_id
where date_format(created_at, '%Y-%m')= '2020-02'
group by mr.movie_id
order by avg(mr.rating)desc , m.title asc
limit 1)