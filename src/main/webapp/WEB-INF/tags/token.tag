<%@tag description="Synchronizer Token" import="abdullah.todomanagement.config.TokenManager" %>

<input
        type="hidden"
        name="<%=TokenManager.getTokenKey()%>"
        value="<%=session.getAttribute(TokenManager.getTokenKey())%>"
/>