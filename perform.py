# print("a")

# a="INSERT INTO Comment (article_id,body) VALUES (1,\'댓글"
# b="\');"

# c="INSERT INTO Nested_Comment (comment_id,body) VALUES ("
# d=", \'대댓글"
# e="\');"
# f = open("sql.txt", "w")


# for i in range(1,1001):
#     for j in range(1,101):
#         f.write(c+str(j)+d+str(i)+e)
#         f.write("\n")
    
    
# f.close()
import time
import requests
import random
import json
f = open("test1.csv", "w")
f.write("time,")
f.write("\n")

for i in range(100):
    search_start = time.time()
    url="http://127.0.0.1:8080/comment?id=1"
    response = requests.get(url).json()


    url="http://127.0.0.1:8080/nestedcomment?commentId="
    for res in response:
        idx=res['id']
        requests.get(url+str(idx))
        
        
    search_time = time.time() - search_start

    f.write(str(round(search_time*1000,2)))
    f.write(',')
    f.write("\n")

    
    
f.close()