<#import "/spring.ftl" as spring>

<html>
    <h1>Welcome  ${principal.getName()}</h1>
    <br>
    <a href="/logout">Logout</a>
    <br>
    <iframe
	    src="${iframeUrl}"
	    frameborder="0"
	    width="2000"
	    height="2000"
	    allowtransparency
	></iframe>
    
</html>