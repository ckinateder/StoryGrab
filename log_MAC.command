cd /Users/ckinateder/NetBeansProjects/StoryGrab
echo "Task,Planned action,Planned outcome,Time estimated,Target completion date" > "logs/log_$(date -I).csv"
git log --date=short --pretty=format:',Work on code,%s, ,%ad (%ar)' >> logs/"log_$(date -I).csv"
echo "Task,Planned action,Planned outcome,Time estimated,Target completion date" > "ia/currentlog.csv"
git log --date=short --pretty=format:',Work on code,%s, ,%ad (%ar)' >> "ia/currentlog.csv"