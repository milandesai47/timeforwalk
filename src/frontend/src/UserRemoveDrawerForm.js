import {Drawer, Input, Col, Form, Row, Button} from 'antd';
import {deleteUser} from "./client";
import {errorNotification, successNotification} from "./Notification";

function UserRemoveDrawerForm({showDeleteDrawer, setShowDeleteDrawer}) {
  const onCLose = () => setShowDeleteDrawer(false);

  const onFinish = email => {
    console.log(email.Email);
    deleteUser(email.Email)
    .then(() => {
      onCLose();
      successNotification("Data removal request received", "Please verify by clicking link in the email")
    }).catch(err => {
      console.log(err);
      onCLose();
      err.response.json().then(res =>{
        console.log(res);
        errorNotification("There was an issue",
            `${res.message}`)
      })
    });
  };

  const onFinishFailed = errorInfo => {
    alert(JSON.stringify(errorInfo, null, 2));
  };

  return <Drawer
      title="Delete my data"
      width={720}
      onClose={onCLose}
      visible={showDeleteDrawer}
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
              name="Email"
              label="Email"
              rules={[{required: true, message: 'Please enter email'}]}
          >
            <Input placeholder="Please enter email"/>
            {/*//TODO : very email are same*/}
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
    </Form>
  </Drawer>
}
export default UserRemoveDrawerForm;
