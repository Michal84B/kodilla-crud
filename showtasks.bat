call runcrud.bat
echo After tomcat start press any key
pause

start "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" http://localhost:8080/crud/v1/task/getTasks

:end
echo.
echo Website loaded.