import React from "react";
import {
  Route,
  Switch,
  Redirect,
  withRouter,
} from "react-router-dom";
import classnames from "classnames";
import {Box, IconButton, Link} from '@material-ui/core'
import Icon from '@mdi/react'

//icons
import {
  mdiFacebook as FacebookIcon,
  mdiTwitter as TwitterIcon,
  mdiGithub as GithubIcon,
} from '@mdi/js'

// styles
import useStyles from "./styles";

// components
import Header from "../Header";
import Sidebar from "../Sidebar";

// pages
import Dashboard from "../../pages/dashboard";
import General from "../../pages/general";
import Typography from "../../pages/typography";
import Maps from "../../pages/maps";
import Icons from "../../pages/icons";
import CarTables from "../../pages/tables/CarTables";
import CarLogTables from "../../pages/tables/CarLogTables";
import CarWarningTables from "../../pages/tables/CarWarningTables";
import CarWarningDetailTables from "../../pages/tables/CarWarningDetailTables";
import CarWarrantyTables from "../../pages/tables/CarWarrantyTables";
import Profile from "../../pages/user/Profile";
import UserTables from "../../pages/tables/UserTables";
import UserCarTables from "../../pages/tables/UserCarTables";
import RoleTables from "../../pages/tables/RoleTables";
import VisualChartTables from "../../pages/tables/VisualChartTables";

// context
import { useLayoutState } from "../../context/LayoutContext";

function Layout(props) {
  var classes = useStyles();

  // global
  var layoutState = useLayoutState();

  return (
    <div className={classes.root}>
        <>
          <Header history={props.history} />
          <Sidebar />
          <div
            className={classnames(classes.content, {
              [classes.contentShift]: layoutState.isSidebarOpened,
            })}
          >
            <div className={classes.fakeToolbar} />
            <Switch>
              <Route path="/app/dashboard" component={Dashboard} />
              <Route path="/app/general" component={General} />
              <Route path="/app/typography" component={Typography} />
              <Route path="/app/car/warningTables" component={CarWarningTables} />
              <Route path="/app/maps" component={Maps} />
              <Route path="/app/icons" component={Icons} />
              <Route
                exact
                path="/app/car"
                render={() => <Redirect to="/app/car/tables" />}
              />
              <Route path="/app/car/tables" component={CarTables} />
              <Route path="/app/car/logTables" component={CarLogTables} />
              <Route path="/app/car/warningTables" component={CarWarningTables} />
              <Route path="/app/car/warningDetailTables" component={CarWarningDetailTables} />
              <Route path="/app/car/warrantyTables" component={CarWarrantyTables} />
              <Route
                exact
                path="/app/user"
                render={() => <Redirect to="/app/user/tables" />}
              />
              <Route path="/app/user/tables" component={UserTables} />
              <Route path="/app/user/userCarTables" component={UserCarTables} />
              <Route path="/app/user/roleTables" component={RoleTables} />
              <Route path="/app/user/profile" component={Profile} />
              <Route path="/app/visualChart/tables" component={VisualChartTables} />
            </Switch>
            <Box
              mt={5}
              width={"100%"}
              display={"flex"}
              alignItems={"center"}
              justifyContent="space-between"
            >
              <div>
                <Link
                  color={'primary'}
                  href={'https://flatlogic.com/'}
                  target={'_blank'}
                  className={classes.link}
                >
                  Flatlogic
                </Link>
                <Link
                  color={'primary'}
                  href={'https://flatlogic.com/about'}
                  target={'_blank'}
                  className={classes.link}
                >
                  About Us
                </Link>
                <Link
                  color={'primary'}
                  href={'https://flatlogic.com/blog'}
                  target={'_blank'}
                  className={classes.link}
                >
                  Blog
                </Link>
              </div>
              <div>
                <Link
                  href={'https://www.facebook.com/flatlogic'}
                  target={'_blank'}
                >
                  <IconButton aria-label="facebook">
                    <Icon
                      path={FacebookIcon}
                      size={1}
                      color="#6E6E6E99"
                    />
                  </IconButton>
                </Link>
                <Link
                  href={'https://twitter.com/flatlogic'}
                  target={'_blank'}
                >
                  <IconButton aria-label="twitter">
                    <Icon
                      path={TwitterIcon}
                      size={1}
                      color="#6E6E6E99"
                    />
                  </IconButton>
                </Link>
                <Link
                  href={'https://github.com/flatlogic'}
                  target={'_blank'}
                >
                  <IconButton
                    aria-label="github"
                    style={{marginRight: -12}}
                  >
                    <Icon
                      path={GithubIcon}
                      size={1}
                      color="#6E6E6E99"
                    />
                  </IconButton>
                </Link>
              </div>
            </Box>
          </div>
        </>
    </div>
  );
}

export default withRouter(Layout);
