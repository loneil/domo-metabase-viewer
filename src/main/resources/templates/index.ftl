<!DOCTYPE html>
<html lang="en">

<head>
    <title>Landing page</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>

<style>

body {
    font-size: .875rem;
  }
  
  .feather {
    width: 16px;
    height: 16px;
    vertical-align: text-bottom;
  }
  
  /*
   * Sidebar
   */
  
  .sidebar {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    z-index: 100; /* Behind the navbar */
    padding: 0;
    box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);
  }
  
  .sidebar-sticky {
    position: -webkit-sticky;
    position: sticky;
    top: 48px; /* Height of navbar */
    height: calc(100vh - 48px);
    padding-top: .5rem;
    overflow-x: hidden;
    overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
  }
  
  .sidebar .nav-link {
    font-weight: 500;
    color: #333;
  }
  
  .sidebar .nav-link .feather {
    margin-right: 4px;
    color: #999;
  }
  
  .sidebar .nav-link.active {
    color: #007bff;
  }
  
  .sidebar .nav-link:hover .feather,
  .sidebar .nav-link.active .feather {
    color: inherit;
  }
  
  .sidebar-heading {
    font-size: .75rem;
    text-transform: uppercase;
  }
  
  /*
   * Navbar
   */
  
  .navbar-brand {
    padding-top: .75rem;
    padding-bottom: .75rem;
    font-size: 1rem;
    background-color: rgba(0, 0, 0, .25);
    box-shadow: inset -1px 0 0 rgba(0, 0, 0, .25);
  }
  
  .navbar .form-control {
    padding: .75rem 1rem;
    border-width: 0;
    border-radius: 0;
  }
  
  .form-control-dark {
    color: #fff;
    background-color: rgba(255, 255, 255, .1);
    border-color: rgba(255, 255, 255, .1);
  }
  
  .form-control-dark:focus {
    border-color: transparent;
    box-shadow: 0 0 0 3px rgba(255, 255, 255, .25);
  }
  
  /*
   * Utilities
   */
  
  .border-top { border-top: 1px solid #e5e5e5; }
  .border-bottom { border-bottom: 1px solid #e5e5e5; }

</style>

<body>
	<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="/">DOMO Metabase Viewer</a>
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="/dashboard">Log In</a>
        </li>
      </ul>
    </nav>
    <div class="container-fluid">
      <main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">DOMO Metabase Viewer</h1>
          <p>This portal allows you to access Metabase dashboards containing Ministry cost analysis information. As the information is proprietary you must request access (will be granted to your IDIR account) to view. If you do not already have access please click Request Access below to send email the Common Services team.</p>
          <p><a class="btn btn-primary btn-lg" href="/dashboard" role="button">Log In Now »</a></p>
          <p><a class="" href="mailto:NR.CommonServiceShowcase@gov.bc.ca?subject=Request Access to DOMO Metabase Viewer" role="button"><i class="fas fa-envelope"></i> Request Access</a></p>
        </div>
      </div>

      <div class="container">
        <h2>Other Common Services team applications:</h2>
        
        <hr>
        <!-- Example row of columns -->
        <div class="row">
          <div class="col-md-4">
            <h3>GETOK</h3>
            <p>For requesting access to and gathering information about IIT common services.</p>
            <p><a class="btn btn-secondary" href="https://github.com/bcgov/nr-get-token" role="button">View details »</a></p>
          </div>
          <div class="col-md-4">
            <h3>CHES</h3>
            <p>A hosted messaging service API providing email, sheduling, and mail-merge functionalies.</p>
            <p><a class="btn btn-secondary" href="https://github.com/bcgov/common-hosted-email-service" role="button">View details »</a></p>
          </div>
          <div class="col-md-4">
            <h3>MSSC</h3>
            <p>Showcasing messaging service common services and providing an interface to bulk send mail merged emails.</p>
            <p><a class="btn btn-secondary" href="https://github.com/bcgov/nr-messaging-service-showcase/" role="button">View details »</a></p>
          </div>
        </div>

      </div> <!-- /container -->

    </main>
    </div>
</body>

</html>