<%@include file="/WEB-INF/view/dynamic/header.jspf"%>
<div class="hero-wrap ftco-degree-bg" style="background-image: url('/resources/images/bg_1.jpg');" data-stellar-background-ratio="0.5">
   <div class="overlay"></div>
   <div class="container">
      <div class="row no-gutters slider-text justify-content-start align-items-center justify-content-center">
         <div class="col-lg-8 ftco-animate">
            <div class="text w-100 text-center mb-md-5 pb-md-5">
               <h1 class="mb-4">Fast &amp; Easy Way To Rent A Car</h1>
               <p style="font-size: 18px;">CHOOSE - RENT - ENJOY!</p>
            </div>
         </div>
      </div>
   </div>
</div>
<section class="ftco-section ftco-no-pt bg-light">
   <div class="container">
      <div class="row justify-content-center">
         <div class="col-md-12 heading-section text-center ftco-animate mb-5">
            <h2 class="mb-2">Accounts</h2>
         </div>
      </div>
      <table class="table table-bordered">
         <thead>
            <tr>
               <th scope="col">Nick</th>
               <th scope="col">First name</th>
               <th scope="col">Last name</th>
               <th scope="col">E-mail</th>
               <th scope="col">Phone number</th>
               <th scope="col"></th>
               <th scope="col"></th>
            </tr>
         </thead>
         <tbody>
            <d:forEach items="${userList}" var="usersEach">
               <tr>
                  <td>${usersEach.nick}</td>
                  <td>${usersEach.firstName}</td>
                  <td>${usersEach.lastName}</td>
                  <td>${usersEach.email}</td>
                  <td>${usersEach.phoneNumber}</td>
                  <td><a href='<c:url value="/edit-account-by-admin/${usersEach.nick}"/>' class="btn btn-secondary btn-lg btn-block">Edit data</a></td>
                  <td><a href='<c:url value="/delete-account/${usersEach.nick}"/>' class="btn btn-danger btn-lg btn-block">Delete account</a></td>
               </tr>
            </d:forEach>
         </tbody>
      </table>
   </div>
</section>
<%@include file="/WEB-INF/view/dynamic/footer.jspf"%>