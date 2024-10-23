 

 <%@ include file="common/header.jspf" %>
 		<%@ include file="common/navigation.jspf" %>
 		
    <div class="container">
      
      <div> 
      <h1> Your todos are</h1? 
      </div>
      <table class="table">
        <thead>
          <tr>
            
            <th>Description</th>
            <th>
              Target Date
            </th>
            <th>Is Done?</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${todos}" var="Todo">
          <tr> 
            <td>${Todo.description}</td>
            <td>${Todo.targetdate}</td>
            <td>${Todo.done}</td>
            <td><a href="delete-todo?id=${Todo.id}" class="btn btn-warning" >DELETE 
            </td>
            <td><a href="update-todo?id=${Todo.id}" class="btn btn-success" >UPDATE 
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
      <a href="add-todo" class="btn btn-success">Add Todo</a> 
<%@ include file="common/footer.jspf" %>