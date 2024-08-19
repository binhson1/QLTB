import React, { useState } from "react";
import { Link } from "react-router-dom";

const Sidebar = () => {
  const [isSidebarVisible, setIsSidebarVisible] = useState(true);

  const toggleSidebar = () => {
    setIsSidebarVisible(!isSidebarVisible);
  };

  return (
    <div
      className={`container-fluid ${
        isSidebarVisible ? "col-2" : "col-1"
      } sidebar`}
    >
      <button
        className="btn btn-primary position-fixed bottom-0 start-0 mb-3 ms-3"
        onClick={toggleSidebar}
      >
        {isSidebarVisible ? "Hide Sidebar" : "Show Sidebar"}
      </button>

      <div className={`row flex-nowrap ${isSidebarVisible ? "" : "d-none"}`}>
        <div className="px-sm-2 px-0 bg-dark">
          <div className="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
            <ul
              className="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start w-100"
              id="menu"
            >
              <li className="border-bottom border-white w-100">
                <Link
                  to="/"
                  data-bs-toggle="collapse"
                  className="nav-link px-0 align-middle"
                >
                  <i className="fs-4 bi-speedometer2"></i>{" "}
                  <span className="ms-1 d-none d-sm-inline text-white">
                    Device
                  </span>{" "}
                </Link>
              </li>
              <li className="border-bottom border-white w-100">
                <Link
                  to="/manufacturer"
                  data-bs-toggle="collapse"
                  className="nav-link px-0 align-middle text-white "
                >
                  <i className="fs-4 bi-speedometer2"></i>{" "}
                  <span className="ms-1 d-none d-sm-inline">Manufacturer</span>{" "}
                </Link>
              </li>
              <li className="border-bottom border-white w-100">
                <Link
                  to="/location"
                  data-bs-toggle="collapse"
                  className="nav-link px-0 align-middle text-white "
                >
                  <i className="fs-4 bi-speedometer2"></i>{" "}
                  <span className="ms-1 d-none d-sm-inline">Location</span>{" "}
                </Link>
              </li>
              <li className="border-bottom border-white w-100">
                <Link
                  to="/report"
                  data-bs-toggle="collapse"
                  className="nav-link px-0 align-middle text-white "
                >
                  <i className="fs-4 bi-speedometer2"></i>{" "}
                  <span className="ms-1 d-none d-sm-inline">Report</span>{" "}
                </Link>
              </li>
              <li className="border-bottom border-white w-100">
                <Link
                  to="/maintenance"
                  data-bs-toggle="collapse"
                  className="nav-link px-0 align-middle text-white "
                >
                  <i className="fs-4 bi-speedometer2"></i>{" "}
                  <span className="ms-1 d-none d-sm-inline">Maintenance</span>{" "}
                </Link>
              </li>

              <li>
                <Link to="/forum" className="nav-link px-0 align-middle">
                  <i className="fs-4 bi-people"></i>{" "}
                  <span className="ms-1 d-none d-sm-inline">Forum</span>{" "}
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Sidebar;
