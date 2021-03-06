import {Drawer, Input, Col, Form, Row, Button, Slider, Spin} from 'antd';
import { LoadingOutlined } from '@ant-design/icons';
import {addUserUser} from "./client";
import {useState} from "react";
import {successNotification, errorNotification} from "./Notification";

const antIcon = <LoadingOutlined style={{ fontSize: 24 }} spin />;

function UserDrawerForm({showDrawer, setShowDrawer,fetchUsers}) {
  const onCLose = () => setShowDrawer(false);
  const [submitting, setSubmitting] = useState(false);

  const onFinish = user => {
    setSubmitting(true)
    console.log(JSON.stringify(user, null, 2))
    addUserUser(user)
      .then(() => {
        onCLose();
        successNotification("Registration Requested", "Please verify registration by clicking the link in email received")
        fetchUsers();
      }).catch(err => {
      console.log(err);
      err.response.json().then(res => {
        console.log(res);
        errorNotification(
            "There was an issue",
            `${res.message}`
        )
      });
    }).finally(() => {setSubmitting(false)})
  };

  const onFinishFailed = errorInfo => {
    alert(JSON.stringify(errorInfo, null, 2));
  };

  return <Drawer
      title="Count me in!"
      width={720}
      onClose={onCLose}
      visible={showDrawer}
      bodyStyle={{paddingBottom: 80}}
      footer={
        <div
            style={{
              textAlign: 'right',
            }}
        >
          <Button onClick={onCLose} style={{marginRight: 8}}>
            Cancel
          </Button>
        </div>
      }
  >
    <Form layout="vertical"
          onFinishFailed={onFinishFailed}
          onFinish={onFinish}
          hideRequiredMark>
      <Row gutter={16}>
        <Col span={12}>
          <Form.Item
              name="name"
              label="Name"
              rules={[{required: true, message: 'Please enter name'}]}
          >
            <Input placeholder="Please enter name"/>
          </Form.Item>
        </Col>
        <Col span={12}>
          <Form.Item
              name="email"
              label="Email"
              rules={[{required: true, message: 'Please enter email'}]}
          >
            <Input placeholder="Please enter email"/>
          </Form.Item>
        </Col>
      </Row>
      <Row gutter={16}>
        <Col span={12}>
          <Form.Item
              name="probability"
              label="probability"
              rules={[{required: true, message: 'Please select probability'}]}
          >
            <Slider defaultValue={30} tooltipVisible />
          </Form.Item>
        </Col>
      </Row>
      <Row>
        <Col span={12}>
          <Form.Item>
            <Button type="primary" htmlType="submit">
              Submit
            </Button>
          </Form.Item>
        </Col>
      </Row>
      <Row>
        {submitting && <Spin indicator={antIcon} />}
      </Row>
    </Form>
  </Drawer>
}
export default UserDrawerForm;
