import {Drawer, Input, Col, Form, Row, Button} from 'antd';


function UserRemoveDrawerForm({showDeleteDrawer, setShowDeleteDrawer}) {
  const onCLose = () => setShowDeleteDrawer(false);

  const onFinish = values => {
    alert(JSON.stringify(values, null, 2));
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
              name="email"
              label="Email"
              rules={[{required: true, message: 'Please enter email'}]}
          >
            <Input placeholder="Please enter email"/>
            <Input placeholder="Please re-enter email"/>
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
