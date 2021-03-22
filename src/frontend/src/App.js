import {useState, useEffect} from 'react'
import './App.css';
import {getAllStudents, getAllCities} from "./client";
import { Layout, Menu, Breadcrumb, Table, Spin, Empty} from 'antd';
import {
  DesktopOutlined,
  PieChartOutlined,
  FileOutlined,
  TeamOutlined,
  UserOutlined,
  LoadingOutlined,
} from '@ant-design/icons';

const { Header, Content, Footer, Sider } = Layout;
const { SubMenu } = Menu;
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
  const [cities, setCities] = useState([])
  const [collapsed, setCollapsed] = useState(false);
  const [fetching, setFetching] = useState(true);


  const fetchUsers = () =>
      getAllStudents()
      .then(res => res.json())
      .then(data => {
        console.log(data)
        setUsers(data);
        setFetching(false);
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
    return <Table
        dataSource={users}
        columns={columns}
        bordered
        title={() => 'Users'}
        pagination={{ pageSize: 50 }}
        scroll={{ y: 240 }}
        rowKey={(user) => user.id} />;
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
      <Header className="site-layout-background" style={{ padding: 0 }} />
      <Content style={{ margin: '0 16px' }}>
        <Breadcrumb style={{ margin: '16px 0' }}>
          <Breadcrumb.Item>User</Breadcrumb.Item>
          <Breadcrumb.Item>Bill</Breadcrumb.Item>
        </Breadcrumb>
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



  // return users.map((user, index) => {
  //   return <p key={index}>{user.id} {user.name} {user.email}</p>;
  // });
}

export default App;
