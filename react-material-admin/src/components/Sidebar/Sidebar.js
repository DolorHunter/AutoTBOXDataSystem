import React, { useState, useEffect } from "react";
import { Drawer, IconButton, List } from "@material-ui/core";
import {
  Home as HomeIcon,
  ViewQuilt as GeneralIcon,
  Map as MapIcon,
  InsertChart as TableIcon,
  ArrowBack as ArrowBackIcon,
  DirectionsCar as CarIcon,
  SupervisorAccount as UserIcon,
} from "@material-ui/icons";
import { useTheme } from "@material-ui/styles";
import { withRouter } from "react-router-dom";
import classNames from "classnames";

// styles
import useStyles from "./styles";

// components
import SidebarLink from "./components/SidebarLink/SidebarLink";

// context
import {
  useLayoutState,
  useLayoutDispatch,
  toggleSidebar,
} from "../../context/LayoutContext";

const structure = [
  { id: 0, label: "数据面板", link: "/app/dashboard", icon: <HomeIcon /> },
  { id: 1, label: "车辆故障概览", link: "/app/general", icon: <GeneralIcon /> },
  { id: 2, label: "车辆故障分布", link: "/app/maps", icon: <MapIcon /> }, 
  { id: 3, label: "车辆故障信息表", link: "/app/car/warningTables", icon: <TableIcon /> },
  {
    id: 4,
    label: "车辆",
    link: "/app/car",
    icon: <CarIcon />,
    children: [
      { label: "车辆列表", link: "/app/car/tables" },
      { label: "车辆日志列表", link: "/app/car/logTables" },
      { label: "车辆故障列表", link: "/app/car/warningTables" },
      { label: "车辆保固列表", link: "/app/car/warrantyTables" },
    ],
  },
  {
    id: 5,
    label: "用户",
    link: "/app/user",
    icon: <UserIcon />,
    children: [
      { label: "用户列表", link: "/app/user/tables" },
      { label: "角色列表", link: "/app/user/roleTables" },
    ],
  },
];

function Sidebar({ location }) {
  var classes = useStyles();
  var theme = useTheme();

  // global
  var { isSidebarOpened } = useLayoutState();
  var layoutDispatch = useLayoutDispatch();

  // local
  var [isPermanent, setPermanent] = useState(true);

  useEffect(function() {
    window.addEventListener("resize", handleWindowWidthChange);
    handleWindowWidthChange();
    return function cleanup() {
      window.removeEventListener("resize", handleWindowWidthChange);
    };
  });

  return (
    <Drawer
      variant={isPermanent ? "permanent" : "temporary"}
      className={classNames(classes.drawer, {
        [classes.drawerOpen]: isSidebarOpened,
        [classes.drawerClose]: !isSidebarOpened,
      })}
      classes={{
        paper: classNames({
          [classes.drawerOpen]: isSidebarOpened,
          [classes.drawerClose]: !isSidebarOpened,
        }),
      }}
      open={isSidebarOpened}
    >
      <div className={classes.toolbar} />
      <div className={classes.mobileBackButton}>
        <IconButton onClick={() => toggleSidebar(layoutDispatch)}>
          <ArrowBackIcon
            classes={{
              root: classNames(classes.headerIcon, classes.headerIconCollapse),
            }}
          />
        </IconButton>
      </div>
      <List className={classes.sidebarList}>
        {structure.map(link => (
          <SidebarLink
            key={link.id}
            location={location}
            isSidebarOpened={isSidebarOpened}
            {...link}
          />
        ))}
      </List>
    </Drawer>
  );

  // ##################################################################
  function handleWindowWidthChange() {
    var windowWidth = window.innerWidth;
    var breakpointWidth = theme.breakpoints.values.md;
    var isSmallScreen = windowWidth < breakpointWidth;

    if (isSmallScreen && isPermanent) {
      setPermanent(false);
    } else if (!isSmallScreen && !isPermanent) {
      setPermanent(true);
    }
  }
}

export default withRouter(Sidebar);
