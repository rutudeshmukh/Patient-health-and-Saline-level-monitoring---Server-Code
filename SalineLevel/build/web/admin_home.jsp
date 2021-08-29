<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="pack.Dbconnection"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
    <%
        int nurseCount = 10;
        int wardCount = 5;
        int patientCount = 100;

    %>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Saline Level - Dashboard</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="admin_home.jsp">Saline Level Monitor</a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>



            <!-- Navbar -->
            <ul class="navbar-nav ml-auto mr-0 mr-md-3 my-2 my-md-0">

                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user-circle fa-fw"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Profile</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
                    </div>
                </li>
            </ul>

        </nav>

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="admin_home.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="view_ward.jsp">
                        <i class="fas fa-fw fa-hotel"></i>
                        <span>Ward Details</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="view_nurse.jsp">
                        <i class="fas fa-fw fa-user-circle"></i>
                        <span>Nurse Details</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="assign_ward.jsp">
                        <i class="fas fa-fw fa-arrows-alt"></i>
                        <span>Assign Ward</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="view_patients.jsp">
                        <i class="fas fa-fw fa-bed"></i>
                        <span>Patient Details</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">
                        <i class="fas fa-fw fa-user-circle"></i>
                        <span>Logout</span></a>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <!--                    <ol class="breadcrumb">
                                            <li class="breadcrumb-item">
                                                <a href="#">Dashboard</a>
                                            </li>
                                            <li class="breadcrumb-item active">Overview</li>
                                        </ol>-->

                    <!-- Icon Cards-->
                    <div class="row">
                        <div class="col-xl-3 col-sm-6 mb-3">
                            <div class="card text-white bg-primary o-hidden h-100">
                                <div class="card-body">
                                    <div class="card-body-icon">
                                        <i class="fas fa-fw fa-hotel"></i>
                                    </div>
                                    <div class="mr-5"><%=wardCount%> Wards!</div>
                                </div>
                                <a class="card-footer text-white clearfix small z-1" href="view_ward.jsp">
                                    <span class="float-left">View Details</span>
                                    <span class="float-right">
                                        <i class="fas fa-angle-right"></i>
                                    </span>
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6 mb-3">
                            <div class="card text-white bg-warning o-hidden h-100">
                                <div class="card-body">
                                    <div class="card-body-icon">
                                        <i class="fas fa-fw fa-doctor"></i>
                                    </div>
                                    <div class="mr-5"><%=nurseCount%> Nurse!</div>
                                </div>
                                <a class="card-footer text-white clearfix small z-1" href="view_nurse.jsp">
                                    <span class="float-left">View Details</span>
                                    <span class="float-right">
                                        <i class="fas fa-angle-right"></i>
                                    </span>
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6 mb-3">
                            <div class="card text-white bg-success o-hidden h-100">
                                <div class="card-body">
                                    <div class="card-body-icon">
                                        <i class="fas fa-fw fa-bed"></i>
                                    </div>
                                    <div class="mr-5"><%=patientCount%> Admitted Patients!</div>
                                </div>
                                <a class="card-footer text-white clearfix small z-1" href="view_patients.jsp">
                                    <span class="float-left">View Details</span>
                                    <span class="float-right">
                                        <i class="fas fa-angle-right"></i>
                                    </span>
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6 mb-3">
                            <div class="card text-white bg-danger o-hidden h-100">
                                <div class="card-body">
                                    <div class="card-body-icon">
                                        <i class="fas fa-fw fa-bed"></i>
                                    </div>
                                    <div class="mr-5"><%=patientCount%> Total Patients!</div>
                                </div>
                                <a class="card-footer text-white clearfix small z-1" href="view_patients.jsp">
                                    <span class="float-left">View Details</span>
                                    <span class="float-right">
                                        <i class="fas fa-angle-right"></i>
                                    </span>
                                </a>
                            </div>
                        </div>
                    </div>

                    <%//load ward details in table

                        Connection con = Dbconnection.getConn();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM admitted_details inner join nurse_details on admitted_details.nurse_id=nurse_details.nurse_id inner join patient_details on patient_details.patient_id=admitted_details.patient_id WHERE admitted_details.status='Admitted'");
                    %>
                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-bed"></i>
                         Admitted Patient Details</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Sr No.</th>
                                            <th>Patient Name</th>
                                            <th>Admitted On</th>
                                            <th>Description</th>
                                            <th>Nurse Name</th>
                                            <th>Ward No</th>
                                            <th>Bed Number</th>

                                        </tr>
                                    </thead>

                                    <tbody>
                                        <%
                                            int i = 1;
                                            while (rs.next()) {
                                        %>
                                        <tr>
                                            <td><%=i++%></td>
                                            <td><%=rs.getString("patient_name")%></td>
                                            <td><%=rs.getString("admitted_on")%></td>
                                            <td><%=rs.getString("description")%></td>
                                            <td><%=rs.getString("name")%></td>
                                            <td><%=rs.getString("ward_id")%></td>
                                            <td><%=rs.getString("bed_number")%></td>
                                        </tr>
                                        <%
                                            }
                                            con.close();
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>

                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <footer class="sticky-footer">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright © Your Website 2019</span>
                        </div>
                    </div>
                </footer>

            </div>
            <!-- /.content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="index.jsp">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="vendor/chart.js/Chart.min.js"></script>
        <script src="vendor/datatables/jquery.dataTables.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin.min.js"></script>

        <!-- Demo scripts for this page-->
        <script src="js/demo/datatables-demo.js"></script>
        <script src="js/demo/chart-area-demo.js"></script>

    </body>

</html>
