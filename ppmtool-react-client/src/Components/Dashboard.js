import React, { Component } from "react";
import ProjectItem from "./project/ProjectItem";
import CreateProjectButton from "./project/CreateProjectButton";

class Dashboard extends Component {
  render() {
    return (
      <div className="projects">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <h1 class="display-4 text-center">Projects</h1>
              <br />
              <CreateProjectButton />
              <br />
              <hr />

              <ProjectItem />
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default Dashboard;
