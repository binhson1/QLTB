const Sidebar = () => {
  return (
    <div className="container-fluid col-2">
      <div className="row flex-nowrap">
        <div className="px-sm-2 px-0 bg-dark">
          <div className="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
            <a
              href="/"
              className="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none"
            >
              <span className="fs-5 d-none d-sm-inline">Menu</span>
            </a>
            <ul
              className="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start w-100"
              id="menu"
            >
              <li className="border-bottom border-white w-100">
                <a
                  href="#deviceMenu"
                  data-bs-toggle="collapse"
                  className="nav-link px-0 align-middle"
                >
                  <i className="fs-4 bi-speedometer2"></i>{" "}
                  <span className="ms-1 d-none d-sm-inline text-white">
                    Device
                  </span>{" "}
                </a>
                <ul
                  className="collapse nav flex-column ms-1 border-bottom ms-3"
                  id="deviceMenu"
                  data-bs-parent="#menu"
                >
                  <li className="w-100 border-bottom border-white">
                    <a href="${d1}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">
                        List devices
                      </span>{" "}
                    </a>
                  </li>
                  <li className="w-100 border-bottom border-white">
                    <a href="${d2}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">
                        Add device
                      </span>{" "}
                    </a>
                  </li>
                  <li className="w-100 border-bottom border-white">
                    <a href="${c1}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">
                        List category
                      </span>{" "}
                    </a>
                  </li>
                  <li className="w-100 border-bottom border-white">
                    <a href="${c2}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">
                        Add category
                      </span>{" "}
                    </a>
                  </li>
                  <li className="w-100 border-bottom border-white">
                    <a href="${m1}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">
                        List manufacturer
                      </span>{" "}
                    </a>
                  </li>
                  <li>
                    <a href="${m2}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">
                        Add manufacturer
                      </span>{" "}
                    </a>
                  </li>
                </ul>
              </li>
              <li className="border-bottom border-white w-100">
                <a
                  href="#locationMenu"
                  data-bs-toggle="collapse"
                  className="nav-link px-0 align-middle text-white "
                >
                  <i className="fs-4 bi-speedometer2"></i>{" "}
                  <span className="ms-1 d-none d-sm-inline">Location</span>{" "}
                </a>
                <ul
                  className="collapse nav flex-column ms-3"
                  id="locationMenu"
                  data-bs-parent="#menu"
                >
                  <li className="w-100 border-bottom border-white">
                    <a href="${l1}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">
                        List location
                      </span>{" "}
                    </a>
                  </li>
                  <li>
                    <a href="${l2}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">
                        Add location
                      </span>{" "}
                    </a>
                  </li>
                </ul>
              </li>
              <li className="border-bottom border-white w-100">
                <a
                  href="#employeeMenu"
                  data-bs-toggle="collapse"
                  className="nav-link px-0 align-middle text-white "
                >
                  <i className="fs-4 bi-speedometer2"></i>{" "}
                  <span className="ms-1 d-none d-sm-inline">Employee</span>{" "}
                </a>
                <ul
                  className="collapse nav flex-column ms-3"
                  id="employeeMenu"
                  data-bs-parent="#menu"
                >
                  <li className="w-100 border-bottom border-white">
                    <a href="${e1}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">
                        List employee
                      </span>{" "}
                    </a>
                  </li>
                  <li>
                    <a href="${e2}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">
                        Add employee
                      </span>{" "}
                    </a>
                  </li>
                </ul>
              </li>
              <li className="border-bottom border-white w-100">
                <a
                  href="#maintenanceMenu"
                  data-bs-toggle="collapse"
                  className="nav-link px-0 align-middle text-white "
                >
                  <i className="fs-4 bi-speedometer2"></i>{" "}
                  <span className="ms-1 d-none d-sm-inline">Maintenance</span>{" "}
                </a>
                <ul
                  className="collapse nav flex-column ms-3"
                  id="maintenanceMenu"
                  data-bs-parent="#menu"
                >
                  <li className="w-100 border-bottom border-white">
                    <a href="${e1}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">
                        List types
                      </span>{" "}
                    </a>
                  </li>
                  <li>
                    <a href="${e2}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">Add type</span>{" "}
                    </a>
                  </li>
                </ul>
              </li>
              <li className="border-bottom border-white w-100">
                <a
                  href="#repairMenu"
                  data-bs-toggle="collapse"
                  className="nav-link px-0 align-middle text-white "
                >
                  <i className="fs-4 bi-speedometer2"></i>{" "}
                  <span className="ms-1 d-none d-sm-inline">Repair</span>{" "}
                </a>
                <ul
                  className="collapse nav flex-column ms-3"
                  id="repairMenu"
                  data-bs-parent="#menu"
                >
                  <li className="w-100 border-bottom border-white">
                    <a href="${r1}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">
                        List types
                      </span>{" "}
                    </a>
                  </li>
                  <li>
                    <a href="${r2}" className="nav-link px-0 text-white">
                      {" "}
                      <span className="d-none d-sm-inline">Add type</span>{" "}
                    </a>
                  </li>
                </ul>
              </li>
              <li>
                <a href="#" className="nav-link px-0 align-middle">
                  <i className="fs-4 bi-people"></i>{" "}
                  <span className="ms-1 d-none d-sm-inline">Customers</span>{" "}
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Sidebar;
