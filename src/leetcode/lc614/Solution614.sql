SELECT f2.followee AS follower, COUNT(DISTINCT f2.follower) AS num
FROM follow f2
WHERE f2.followee IN
  (SELECT DISTINCT f1.follower
  FROM follow f1)
GROUP BY f2.followee
ORDER BY f2.followee