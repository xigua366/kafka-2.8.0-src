/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.message;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.AlterIsrResponseData.*;

public class AlterIsrResponseDataJsonConverter {
    public static AlterIsrResponseData read(JsonNode _node, short _version) {
        AlterIsrResponseData _object = new AlterIsrResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("AlterIsrResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "AlterIsrResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("AlterIsrResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "AlterIsrResponseData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("AlterIsrResponseData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("AlterIsrResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<TopicData> _collection = new ArrayList<TopicData>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(TopicDataJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(AlterIsrResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        _node.set("errorCode", new ShortNode(_object.errorCode));
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (TopicData _element : _object.topics) {
            _topicsArray.add(TopicDataJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        return _node;
    }
    public static JsonNode write(AlterIsrResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class PartitionDataJsonConverter {
        public static PartitionData read(JsonNode _node, short _version) {
            PartitionData _object = new PartitionData();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "PartitionData");
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "PartitionData");
            }
            JsonNode _leaderIdNode = _node.get("leaderId");
            if (_leaderIdNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'leaderId', which is mandatory in version " + _version);
            } else {
                _object.leaderId = MessageUtil.jsonNodeToInt(_leaderIdNode, "PartitionData");
            }
            JsonNode _leaderEpochNode = _node.get("leaderEpoch");
            if (_leaderEpochNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'leaderEpoch', which is mandatory in version " + _version);
            } else {
                _object.leaderEpoch = MessageUtil.jsonNodeToInt(_leaderEpochNode, "PartitionData");
            }
            JsonNode _isrNode = _node.get("isr");
            if (_isrNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'isr', which is mandatory in version " + _version);
            } else {
                if (!_isrNode.isArray()) {
                    throw new RuntimeException("PartitionData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_isrNode.size());
                _object.isr = _collection;
                for (JsonNode _element : _isrNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "PartitionData element"));
                }
            }
            JsonNode _currentIsrVersionNode = _node.get("currentIsrVersion");
            if (_currentIsrVersionNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'currentIsrVersion', which is mandatory in version " + _version);
            } else {
                _object.currentIsrVersion = MessageUtil.jsonNodeToInt(_currentIsrVersionNode, "PartitionData");
            }
            return _object;
        }
        public static JsonNode write(PartitionData _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            _node.set("leaderId", new IntNode(_object.leaderId));
            _node.set("leaderEpoch", new IntNode(_object.leaderEpoch));
            ArrayNode _isrArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.isr) {
                _isrArray.add(new IntNode(_element));
            }
            _node.set("isr", _isrArray);
            _node.set("currentIsrVersion", new IntNode(_object.currentIsrVersion));
            return _node;
        }
        public static JsonNode write(PartitionData _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class TopicDataJsonConverter {
        public static TopicData read(JsonNode _node, short _version) {
            TopicData _object = new TopicData();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("TopicData: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("TopicData expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("TopicData: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("TopicData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<PartitionData> _collection = new ArrayList<PartitionData>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(PartitionDataJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(TopicData _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (PartitionData _element : _object.partitions) {
                _partitionsArray.add(PartitionDataJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(TopicData _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
