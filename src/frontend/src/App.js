import {useState, useEffect} from 'react'
import './App.css';
import {getAllUsers, getAllCities} from "./client";
import {
  Layout,
  Menu,
  Breadcrumb,
  Table,
  Spin,
  Empty,
  Button,
  Col,
  Statistic,
  Row,
  Card,
  Typography
} from 'antd';
import {
  DesktopOutlined,
  PieChartOutlined,
  FileOutlined,
  TeamOutlined,
  UserOutlined,
  LoadingOutlined,
  UserAddOutlined, UserDeleteOutlined, LikeOutlined, ArrowUpOutlined
} from '@ant-design/icons';
import UserDrawerForm from "./UserDrawerForm";
import UserRemoveDrawerForm from "./UserRemoveDrawerForm";
import {errorNotification} from "./Notification";

const { Header, Content, Footer, Sider } = Layout;
const { SubMenu } = Menu;
const { Title } = Typography;
const columns = [
  {
    title: 'Id',
    dataIndex: 'id',
    key: 'id',
  },
  {
    title: 'Name',
    dataIndex: 'name',
    key: 'name',
  },
  {
    title: 'email',
    dataIndex: 'email',
    key: 'email',
  },
  {
    title: 'Probability',
    dataIndex: 'probability',
    key: 'probability',
  },
];

const cityColumns = [
  {
    title: 'Id',
    dataIndex: 'id',
    key: 'id',
  },
  {
    title: 'Name',
    dataIndex: 'name',
    key: 'name',
  },
  {
    title: 'lon',
    dataIndex: 'lon',
    key: 'lon',
  },
  {
    title: 'lat',
    dataIndex: 'lat',
    key: 'lat',
  },
];


const antIcon = <LoadingOutlined style={{ fontSize: 24 }} spin />;

function App() {
  const [users, setUsers] = useState([]);
  const [cities, setCities] = useState([]);
  const [collapsed, setCollapsed] = useState(false);
  const [fetching, setFetching] = useState(true);
  const [showDrawer, setShowDrawer] = useState(false);
  const [showDeleteDrawer, setShowDeleteDrawer] = useState(false);

  const fetchUsers = () =>
      getAllUsers()
      .then(res => res.json())
      .then(data => {
        setUsers(data);
        setFetching(false);
      }).catch(err => {
        console.log(err);
        err.response.json().then(res => {
          console.log(res);
          errorNotification(
              "There was an issue",
              `${res.message}`
          )
        });
      });

  const fetchCities = () =>
      getAllCities()
      .then(res => res.json())
      .then(data => {
        console.log(data)
        setCities(data)
        setFetching(false);
      });

  useEffect(() => {
    console.log("component mounted");
    fetchUsers();
    fetchCities();
  }, []);

  const renderUsers = () => {
    if(fetching) {
      return <Spin indicator={antIcon} />
    }
    if(users.length <= 0) {
      return <Empty />
    }
    return <>
      <UserDrawerForm
          showDrawer={showDrawer}
          setShowDrawer={setShowDrawer}
          fetchUsers={fetchUsers}
      />
      <UserRemoveDrawerForm
          showDeleteDrawer={showDeleteDrawer}
          setShowDeleteDrawer={setShowDeleteDrawer}
      />
    <Table
        dataSource={users}
        columns={columns}
        bordered
        title={() =>
          <Button
              onClick={() => setShowDrawer(!showDrawer)}
              type="primary" shape="round" icon={<UserAddOutlined />} size="large">
            Count me in!
          </Button>

        }
        pagination={{ pageSize: 50 }}
        scroll={{ y: 240 }}
        rowKey={(user) => user.id} />;

      </>
  }

  const renderCities  = () => {
    if(fetching) {
      return <Spin indicator={antIcon} />
    }
    if(users.length <= 0) {
      return <Empty />
    }
    return <Table
        dataSource={cities}
        columns={cityColumns}
        bordered
        title={() => 'Supported Cities'}
        pagination={{ pageSize: 50 }}
        scroll={{ y: 240 }}
        rowKey={(city) => city.id} />;
  }

  return <Layout style={{ minHeight: '100vh' }}>
    <Sider collapsible collapsed={collapsed}
           onCollapse={setCollapsed}>
      <div className="logo" />
      <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
        <Menu.Item key="1" icon={<PieChartOutlined />}>
          Option 1
        </Menu.Item>
        <Menu.Item key="2" icon={<DesktopOutlined />}>
          Option 2
        </Menu.Item>
        <SubMenu key="sub1" icon={<UserOutlined />} title="User">
          <Menu.Item key="3">Tom</Menu.Item>
          <Menu.Item key="4">Bill</Menu.Item>
          <Menu.Item key="5">Alex</Menu.Item>
        </SubMenu>
        <SubMenu key="sub2" icon={<TeamOutlined />} title="Team">
          <Menu.Item key="6">Team 1</Menu.Item>
          <Menu.Item key="8">Team 2</Menu.Item>
        </SubMenu>
        <Menu.Item key="9" icon={<FileOutlined />}>
          Files
        </Menu.Item>
      </Menu>
    </Sider>
    <Layout className="site-layout">
      <Header className="site-layout-background" style={{ padding: 0 }} > <Title level={2}>Timeforwalk</Title></Header>
      <Content style={{ margin: '0 16px' }}>
        <Breadcrumb style={{ margin: '20px 0' }}>
          <Breadcrumb.Item>

          </Breadcrumb.Item>
        </Breadcrumb>
        <div className="site-layout-background" style={{ padding: 24, minHeight: 50 }}>

        </div>
        <div className="site-layout-background" style={{ padding: 24, minHeight: 50 }}>
          <Row gutter={16}>
            <Col>
            <Card>
              <Statistic
                  title="Active Users"
                  value={users.length}
                  precision={0}
                  valueStyle={{ color: '#3f8600' }}
                  prefix={<ArrowUpOutlined />}
                  suffix=""
              />
            </Card>
            </Col>
            <Col>
              <Button
                  onClick={() => setShowDrawer(!showDrawer)}
                  type="primary" shape="round" icon={<UserAddOutlined />} size="large">
                Count me in!
              </Button>
            </Col>
            <Col>
              <Button danger
                      onClick={() => setShowDeleteDrawer(!showDeleteDrawer)}
                      type="primary" shape="round" icon={<UserDeleteOutlined />} size="large">
                Delete my data
              </Button>
            </Col>
          </Row>
        </div>
        <div className="site-layout-background" style={{ padding: 24, minHeight: 360 }}>
          {renderUsers()}
        </div>
        <div className="site-layout-background" style={{ padding: 24, minHeight: 360 }}>
          {renderCities()}
        </div>
      </Content>
      <Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Footer>
    </Layout>
  </Layout>
}

export default App;
